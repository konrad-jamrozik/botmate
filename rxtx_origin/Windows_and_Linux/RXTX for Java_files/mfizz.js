var Analytics = function () {
    return {
        init: function () {
            (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
            })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

            ga('create', 'UA-40949837-1', 'auto');
            ga('send', 'pageview');
        }
    };
}();

var Articlez = function () {
    return {
        init: function () {
            // format articlez tables
            $(".article-content table").addClass("table table-hover table-condensed table-bordered table-striped");

            // append external link icon and force open new window for articles
            $('.article-content a.external').filter(function () {
                // only return true if the host is different than current
                return this.hostname && this.hostname !== location.hostname;
            }).filter(function () {
                // only return true if the target link isn't a .zip, .exe, etc
                return this.href && !this.href.toLowerCase().match("\\.(zip|exe|gz|bz2)$");
            }).attr("target", "_blank").after(' <i class="icon-external-link"></i>');

            // format code blocks
            prettyPrint();
        }
    };
}();

var Contact = function () {
    return {
        // Contact form via ajax
        initForm: function () {
            $("#contact-ajaxform-container").ajaxForm();
        },
        initMap: function () {
            map = new GMaps({
                div: '#map',
                lat: 42.4894444,
                lng: -83.1447222,
                zoom: 10,
                scrollwheel: false
            });

            var marker = map.addMarker({
                lat: 42.4894444,
                lng: -83.1447222,
                title: 'Fizzed, Inc.'
            });
        }
    };
}();