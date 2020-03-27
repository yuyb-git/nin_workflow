$(function () {

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
    let imagedata = canvas.toDataURL('image/png');
    // 如果浏览器支持msSaveOrOpenBlob方法（也就是使用IE浏览器的时候）
    if (window.navigator.msSaveOrOpenBlob) {
        let bstr = atob(imagedata.split(',')[1]);
        let n = bstr.length;
        let u8arr = new Uint8Array(n);
        while (n--) {
            u8arr[n] = bstr.charCodeAt(n);
        }
        let blob = new Blob([u8arr]);
        window.navigator.msSaveOrOpenBlob(blob, modelName+'.png');
    }else{
        let a = document.createElement('a');
        a.href = imagedata;  //将画布内的信息导出为png图片数据
        a.download = modelName;  //设定下载名称
        a.click(); //点击触发下载
    }
};