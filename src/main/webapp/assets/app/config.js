/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @Project Happy-Cooperation  
 * @Filename config.js
 * @Author Huzi.Wang [huzi.wh@gmail.com]
 * @Link http://imhuzi.net/
 * @Date Nov 17, 2013 12:32:10 AM
 * @Version 2.0 
 * @Copyright Copyright(c) 2013 http://imhuzi.net
 * @Description 
 *     Description of config
 */

require.config({
    baseUrl: '/assets',
    paths: {
        'jQuery': './jquery/jquery-1.9.1.min',
        'angular': './angular/angular',
        'bootstrap': './bootstrap/js/bootstrap'
//        'angular-resource': '//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular-resource'
    },
    shim: {
         'bootstrap': {
          deps: ['jQuery'],
          exports: '$.fn.popover'
        },
        'angular': {'exports': 'angular'},
//        'angular-resource': {deps: ['angular']},
        'jQuery': {'exports': 'jQuery'}
    }
});

