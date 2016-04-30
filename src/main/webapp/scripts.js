$(document).ready(function () {

    $('#city').focus(function () {
        $('#billboard').empty();
    });

    var getWeather = function () {

        var city = $('#city').val();

        if (city == '') {
            $('#billboard').html("<h1 class='loading'>Hold on... Searching weather information for Sydney as the default city...</h2>");
        } else {
            $('#billboard').html("<h1 class='loading'>Hold on... Searching weather information for " + city + "</h2>");
        }
        $.getJSON("rest/weather/current/" + city, function (json) {
            if (json) {
                var items = [];
                $.each(json, function (key, val) {
                    switch (key) {
                        case 'main':
                        case 'rain':
                            $.each(val, function (k, v) {
                                items.push("<tr><td>" + k + "</td><td>" + v + "</td></tr>");
                            });
                            break;
                        case 'wind':
                            $.each(val, function (k, v) {
                                if (k=='deg')
                                    items.push("<tr><td>wind direction</td><td>" + v + "</td></tr>");
                                else
                                    items.push("<tr><td>wind speed</td><td>" + v + "</td></tr>");
                            });
                            break;
                        case 'name':
                            items.push("<tr><td>City</td><td>" + val + "</td></tr>");
                            break;
                        case 'clouds':
                            $.each(val, function (k, v) {
                                items.push("<tr><td>clouds</td><td>" + v + "</td></tr>");
                            });
                    }
                });
                $("#billboard").html("<table>" + items.join("") + "</table>");
            } else {
                console.log(json);
                $('#billboard').html('<h1 class="loading">Nothing found.');
            }
        });

    }

    $('#search').click(getWeather);
    $('#city').keyup(function (event) {
        if (event.keyCode == 13) {
            getWeather();
        }
    });

});