//全局共享的库路径配置文件
require.config({
    //baseUrl: RD.cdnCommonRoot,
    baseUrl: '/static/js/',
    waitSeconds: 0,
    paths: {
        jquery: 'libs/jquery-1.11.1.min',
        jquerybase: 'libs/jquery.base64',
        bootstrap: 'libs/bootstrap/js/bootstrap.min',
        layer: 'libs/layer/layer',
        iview: 'libs/iview/iview.min',
        adminlte:'libs/AdminLTE/js/adminlte.min',
        canvg:'libs/canvg/canvg.min',
        vue:'libs/vue/vue.min',
        localstorage:'localstorage/localstorage',
        jqueryutils:'localstorage/jquery.utils',
        rgbcolor:'libs/canvg/rgbcolor.min',
        stackblur:'libs/canvg/stackblur.min',
        bpmndevelop:'bpmn/js/bpmn-modeler.development',
        common:'common',
        customTranslate:'bpmn/js/customTranslate',
        translations:'bpmn/js/translations',
    },
    shim: {
        'jquery':{
            exports:'jquery'
        },
        'jquerybase':{
            exports:'jquerybase'
        },
        'bootstrap': {
            deps: ['jquery'],
            exports: 'bootstrap'
        },
        'layer': {
            deps: ['jquery'],
            exports: 'layer'
        },
        'iview': {
            deps: ['jquery'],
            exports: 'iview'
        },
        'adminlte': {
            deps: ['jquery'],
            exports: 'adminlte'
        },
        'canvg': {
            deps: ['jquery'],
            exports: 'canvg'
        },
        'vue': {
            deps: ['jquery'],
            exports: 'vue'
        },
        'localstorage': {
            deps: ['jquery'],
            exports: 'localstorage'
        },
        'jqueryutils': {
            deps: ['jquery'],
            exports: 'jqueryutils'
        },
        'rgbcolor': {
            exports: 'rgbcolor'
        },
        'stackblur': {
            exports: 'stackblur'
        },
        'common': {
            deps: ['jquery'],
            exports: 'common'
        },
        'customTranslate': {
            deps: ['translations'],
            exports: 'customTranslate'
        },

    }
});
