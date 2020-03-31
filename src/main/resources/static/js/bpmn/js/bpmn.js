import customTranslate from '/static/js/bpmn/js/customTranslate.js';
//import propertiesPanelModule from '../../bpmn-js-properties-panel';
//import propertiesProviderModule from '../../bpmn-js-properties-panel/lib/provider/camunda';
//import camundaModdleDescriptor from 'camunda-bpmn-moddle/resources/camunda.json';
let customTranslateModule = {
    translate: [ 'value', customTranslate ]
};
let bpmnModeler = new BpmnJS({
	container: '#canvas',
	propertiesPanel: {
		parent: '#js-properties-panel'
	},
    keyboard: {
        bindTo: window
    },
    additionalModules: [
        customTranslateModule,
		//propertiesPanelModule,
		//propertiesProviderModule
    ]
});

let bpmnId = "";
let bpmnName = "";
$(function() {
	bpmnId =  bpmn.LocalStorage.get({
		key : "bpmnId"
	});
	bpmnName =  bpmn.LocalStorage.get({
		key : "bpmnName"
	});
	$("#modelName").val(bpmnName);
	let bpmnXml = bpmn.LocalStorage.get({
		key : "bpmn"+bpmnId
	});
	if(bpmnXml === ""){//优先走本地缓存，保存以后记得清除
		if(bpmnId !== ""){
			$.SetForm({
				url :  "/bpmn/get",
				param : {"id":bpmnId},
				json:true,
				async :false,
				success : function(result) {
					bpmnXml = result.bpmnXml;
					$("#modelName").val(result.modelName)
				}
			});
		}
	}
	//openDiagram(bpmnXml);
	let timer = window.setInterval(function(){
		bpmnModeler.saveXML({ format: true }, function(err, xml) {
			if (err) {
				return console.error('could not save BPMN 2.0 diagram', err);
			}
			//保存单个对象
			bpmn.LocalStorage.set({
				key : "bpmn"+bpmnId,
				value : xml,
			});
			bpmnXml = bpmn.LocalStorage.get({
				key : "bpmn"+bpmnId
			});
		});
	}, 1000);
});

/**
 * Save diagram contents and print them to the console.
 */
window.exportDiagram = function () {
    bpmnModeler.saveXML({format: true}, function (err, xml) {
        if (err) {
            return console.error('could not save BPMN 2.0 diagram', err);
        }
		let modelName = $.trim($("#modelName").val());
        if (modelName === "") {
            pop.info("请输入流程名称");
            return;
        }

		let blob = null;
        // 如果浏览器支持msSaveOrOpenBlob方法（也就是使用IE浏览器的时候）
        if (window.navigator.msSaveOrOpenBlob) {
            blob = new Blob([xml], {type: 'text/plain'});
            window.navigator.msSaveOrOpenBlob(blob, modelName + '.bpmn');
        } else {
            var eleLink = document.createElement('a');
            eleLink.download = modelName + ".bpmn";
            eleLink.style.display = 'none';
            blob = new Blob([xml], {type: 'text/plain'});  // 字符内容转变成blob地址
            eleLink.href = URL.createObjectURL(blob);
            document.body.appendChild(eleLink);  // 触发点击
            //eleLink.click();
            document.body.removeChild(eleLink);   // 然后移除
        }

		let _canvas = document.querySelector('svg');
		let w = parseInt(window.getComputedStyle(_canvas).width);
		let h = parseInt(window.getComputedStyle(_canvas).height);
		let svgXml = $('svg').html();
		let base = '<svg width="' + w + 'px" height="' + h + 'px" style="touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);" data-element-id="Process_1" class="">';
        svgXml = base + svgXml + "</svg>";
		let canvas = document.createElement('canvas');  //准备空画布
        canvg(canvas, svgXml);
		let bpmnImage = canvas.toDataURL('image/png');
        $.SaveForm({
            url: "/bpmn/save",
            param: {"bpmnXml": xml, "modelName": modelName},
            json: true,
            success: function (result) {
                var id = result.msg;
                pop.success("保存成功");
                $('.sidebar-menu', parent.document).find("li[data-src='bpmn/index.shtml']").trigger("click");
            }
        });
    });
};

/**
 * Open diagram in our modeler instance.
 * @param {String} bpmnXML diagram to display
 */
window.openDiagram = function (bpmnXML) {
    if (bpmnXML === "" || bpmnXML === null) {
        bpmnXML = '<?xml version="1.0" encoding="UTF-8"?>\n' +
            '<bpmn2:definitions xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" xsi:schemaLocation="http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd" id="sample-diagram" targetNamespace="http://bpmn.io/schema/bpmn">\n' +
            '  <bpmn2:process id="Process_1">\n' +
            '    <bpmn2:startEvent id="StartEvent_1"/>\n' +
            '  </bpmn2:process>\n' +
            '  <bpmndi:BPMNDiagram id="BPMNDiagram_1">\n' +
            '    <bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Process_1">\n' +
            '      <bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">\n' +
            '        <dc:Bounds height="36.0" width="36.0" x="412.0" y="240.0"/>\n' +
            '      </bpmndi:BPMNShape>\n' +
            '    </bpmndi:BPMNPlane>\n' +
            '  </bpmndi:BPMNDiagram>\n' +
            '</bpmn2:definitions>'; //BPMN 2.0 xml
    }
    // import diagram
    bpmnModeler.importXML(bpmnXML, function (err) {
        if (err) {
            return console.error('could not import BPMN 2.0 diagram', err);
        }
    });
};
openDiagram("");
$('#fullscreen').click(function() {
	let screen = isFull();
	if (screen) {
		exitScreen();
	} else {
		fullScreen();
	}
});
// 网页全屏代码
function fullScreen() {
	// ie10以下全屏模式
	if (window.ActiveXObject) {
		let wscript = new ActiveXObject("WScript.Shell");
		if (wscript) {
			wscript.SendKeys("{F11}");
			return;
		} else {
			console.log('用户拒接或者加载插件失败');
		}
	};
	// 判断各种浏览器，找到正确的方法
	function fullScreen(obj) {
		if (obj.requestFullscreen) {
			obj.requestFullscreen();
		} else if (obj.mozRequestFullScreen) {
			obj.mozRequestFullScreen();
		} else if (obj.webkitRequestFullscreen) {
			obj.webkitRequestFullscreen();
		} else if (obj.msRequestFullscreen) {
			obj.msRequestFullscreen();
		} else {
			console.log('该浏览器不支持全屏，请升级最新版本');
		}
	}
	// 启动全屏
	fullScreen($('html').get(0)); // 整个网页
	// fullScreen(document.getElementById("videoElement")); //某个页面元素
};

// 退出全屏代码
function exitScreen() {
	// ie10以下全屏模式
	if (window.ActiveXObject) {
		let wscript = new ActiveXObject("WScript.Shell");
		if (wscript) {
			wscript.SendKeys("{F11}");
			return;
		}
	}
	// 判断浏览器种类
	function exit() {
		if (document.exitFullscreen) {
			document.exitFullscreen();
		} else if (document.mozCancelFullScreen) {
			document.mozCancelFullScreen();
		} else if (document.webkitExitFullscreen) {
			document.webkitExitFullscreen();
		} else if (document.msExitFullscreen) {
			document.msExitFullscreen();
		}
	}
	// 退出全屏模式!
	exit();
};
// 判断是否全屏
function isFull() {
	let explorer = window.navigator.userAgent.toLowerCase();
	let full;
	if (explorer.indexOf('chrome') > 0) {// chrome
		if (document.body.scrollHeight === window.screen.height
				&& document.body.scrollWidth === window.screen.width) {
			full = true;
		} else {
			full = false;
		}
	} else {// IE 9+ fireFox
		if (window.outerHeight === window.screen.height
				&& window.outerWidth === window.screen.width) {
			full = true;
		} else {
			full = false;
		}
	};
	return full;
}
$('#keybindings').click(function() {
	$("#help").show();
});
//创建一个新的
window.createNew = function (){
	layer.confirm('确定要重新创建一个BPMN？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		layer.closeAll();
		openDiagram("")
	}, function() {
		
	});
};
//打开本地BPMN
window.openLocal = function () {
	document.getElementById("btn_file").click(); 
};

//展示BPMN
window.showBPMN = function (){
	let file = document.getElementById('btn_file').files[0];
    let URL = window.URL || window.webkitURL;
	let imgURL = URL.createObjectURL(file);
    $.get(imgURL,function(xmlDoc,textStatus){
          openDiagram(xmlDoc);
    });
};

/**
 * base64 转 blob 对象，文件上传
 * @param dataURI
 * @returns {Blob}
 */
function dataURItoBlob(dataURI) {
    var byteString = atob(dataURI.split(',')[1]);
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], {type: mimeString});
}

function dataURLtoBlob(dataurl) {
	let arr = dataurl.split(',');
	//注意base64的最后面中括号和引号是不转译的
	let _arr = arr[1].substring(0,arr[1].length-2);
	let mime = arr[0].match(/:(.*?);/)[1],
		bstr =atob(_arr),
		n = bstr.length,
		u8arr = new Uint8Array(n);
	while (n--) {
		u8arr[n] = bstr.charCodeAt(n);
	}
	return new Blob([u8arr], {
		type: mime
	});
}

//下载SVG
window.downloadSVG = function (){
	let modelName = $.trim($("#modelName").val());
	if(modelName === ""){
		pop.info("请输入流程名称");
		return;
	}
	let _canvas = document.querySelector('svg');
	let w = parseInt(window.getComputedStyle(_canvas).width);
	let h = parseInt(window.getComputedStyle(_canvas).height);
	let svgXml = $('svg').html();
	let base = '<svg width="'+w+'px" height="'+h+'px" style="touch-action: none; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);" data-element-id="Process_1" class="">'
	svgXml = base + svgXml +"</svg>";
	let canvas = document.createElement('canvas');  //准备空画布
	 canvg(canvas, svgXml);
	 //.toDataURL('image/png')
	let dataURL = canvas.toDataURL('image/png');
	let $Blob = dataURItoBlob(dataURL);
     // 如果浏览器支持msSaveOrOpenBlob方法（也就是使用IE浏览器的时候）
	let formData = new FormData();
	formData.append("file", $Blob, "image.png");
	formData.append("modelName", modelName);

	$.ajax({
		url: '/bpmn/upload',
		type: "post",
		contentType: false,
		processData: false,
		dataType: 'json',
		mimeType: "multipart/form-data",
		data: formData,
		success: function(response) {
			if(response.code === 200){
				layer.msg("保存成功");
			}
		}
	});
};