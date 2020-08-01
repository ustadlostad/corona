<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Corona Info</title>
    <link rel="icon" href="https://image.flaticon.com/icons/svg/2760/2760528.svg">
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
          crossorigin="anonymous"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
</head>

<body>


<script type="text/javascript" src=https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<%--<script src="<c:url value="/resources/graph1/js/main.js" />"></script>--%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>

<div>
    <div class="row">
        <div class="col-4">.

            <br>

            <h1 style="text-align: center">Global Stats</h1>

            <ul class="list-group mx-auto" style="width: 500px">

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Confirmed Cases
                    <span class="badge badge-primary badge-pill">${totalConfirmed}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Deaths
                    <span class="badge badge-primary badge-pill">${totalDeaths}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Recovered
                    <span class="badge badge-primary badge-pill">${totalRecovered}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Active Cases
                    <span class="badge badge-primary badge-pill">${totalActive}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Last Update
                    <span class="badge badge-primary badge-pill">${lastUpdate}</span>
                </li>
            </ul>
        </div>
        <div class="container">
            <div class="col">
                <br>
                <canvas id="my2Chart" height="400" width="1100"></canvas>
            </div>
        </div>

    </div>
</div>

<br>
<br>

<div class="col my-auto" align="center">
    <form method="get" action="/" id="form-id" style="width: 500px">
        <div class="form-group">
            <label for="exampleFormControlSelect1">Select Country</label>
            <select name="country" class="form-control" id="exampleFormControlSelect1"
                    onchange="document.getElementById('form-id').submit();">
                <c:forEach var="country" items="${countryMap}">
                    <c:choose>
                        <c:when test="${parameter == country.key}">
                            <option selected value="${country.key}">${country.value}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${country.key}">${country.value}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div style="display: none"><%= request.getParameter("country") %>
        </div>
    </form>
</div>

<br>

<div>
    <div class="row">
        <div class="col-4">

            <h1 style="text-align: center">${countryName}</h1>

            <ul class="list-group mx-auto" style="width: 500px">

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Confirmed Cases
                    <span class="badge badge-primary badge-pill">${countryConfirmed}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Deaths
                    <span class="badge badge-primary badge-pill">${countryDeaths}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Recovered Cases
                    <span class="badge badge-primary badge-pill">${countryRecovered}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Active Cases
                    <span class="badge badge-primary badge-pill">${countryActive}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Last Update
                    <span class="badge badge-primary badge-pill">${lastUpdate}</span>
                </li>
            </ul>
        </div>

        <div class="container">
            <div class="col">
                <canvas id="my1Chart" height="400" width="1100"></canvas>
            </div>
        </div>
    </div>
</div>

<script>
    // Bar chart
    var usa = ${usa};
    var brasil = ${brasil};
    var india = ${india};
    var russia = ${russia};
    var peru = ${peru};
    new Chart(document.getElementById("my2Chart"), {
        type: 'bar',
        data: {
            labels: ["USA", "Brazil", "India", "Russia", "Peru"],
            datasets: [
                {
                    label: "Active Cases",
                    backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                    data: [usa,brasil,india,russia,peru]
                }
            ]
        },
        options: {
            legend: {display: false},
            title: {
                display: true,
                text: 'Top 5 Countries In Terms Of Active Cases'
            }
        }
    });

</script>

<script>

    var ctx1 = document.getElementById("my1Chart").getContext('2d');

    var confirmedCasesDayByDay = ${confirmedCasesDayByDay};
    var graphDataXaxis = [${xAxis}];
    var deathDataDayByDay = ${deathsNumbersDayByDay};
    var recoveredDataDayByDay = ${recoveredNumbersDayByDay};

    console.log(confirmedCasesDayByDay);
    console.log(deathDataDayByDay);
    console.log(recoveredDataDayByDay);
    console.log(graphDataXaxis);

    var my1Chart = new Chart(ctx1, {
        type: 'line',
        data: {
            labels: graphDataXaxis,
            lineTension: 0.1,
            fill: true,
            datasets: [{
                label: 'Confirmed Cases', // Name the series
                data: confirmedCasesDayByDay, // Specify the data values array
                fill: false,
                borderColor: '#EEB534', // Add custom color border (Line)
                backgroundColor: '#EEB534', // Add custom color background (Points and Fill)
                borderWidth: 3 // Specify bar border width
            },

                {
                    label: 'Deaths', // Name the series
                    data: deathDataDayByDay, // Specify the data values array
                    fill: false,
                    borderColor: '#DFA5A6', // Add custom color border (Line)
                    backgroundColor: '#DFA5A6', // Add custom color background (Points and Fill)
                    borderWidth: 3 // Specify bar border width
                },

                {
                    label: 'Recovered', // Name the series
                    data: recoveredDataDayByDay, // Specify the data values array
                    fill: false,
                    borderColor: '#AFC7CE', // Add custom color border (Line)
                    backgroundColor: '#AFC7CE', // Add custom color background (Points and Fill)
                    borderWidth: 3 // Specify bar border width
                }

            ]
        },
        options: {
            title: {
                display: true,
                text: 'Statistics Day By Day'
            },
            responsive: false, // Instruct chart js to respond nicely.
            maintainAspectRatio: true, // Add to prevent default behaviour of full-width/heigh
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                    }

                }

                ],
                xAxes: [{
                    ticks: {
                        autoSkip: true,
                        maxTicksLimit: 7,
                    }
                }]
            }

        }
    });
</script>

</body>
</html>