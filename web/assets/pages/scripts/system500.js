/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var Error500 = function () {
    return{
        init: function () {
            e(), r(), s(), $.backstretch([
                "./assets/pages/media/bg/1.jpg",
                "./assets/pages/media/bg/2.jpg",
                "./assets/pages/media/bg/3.jpg",
                "./assets/pages/media/bg/4.jpg"],
                    {
                        fade: 1e3,
                        duration: 8e3
                    });
        }};
}();
jQuery(document).ready(function () {
    Error500.init();
});