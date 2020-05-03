<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Corona Stats</title>
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<script type="text/javascript" src = https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<%--<script src="<c:url value="/resources/graph1/js/main.js" />"></script>--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<div class="container">
    <div class="row">
        <div class="col">
            <h1 style="text-align: center">Global Stats</h1>

            <ul class="list-group">

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Confirmed Cases
                    <span class="badge badge-primary badge-pill">${totalConfirmed}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    New Confirmed Cases
                    <span class="badge badge-primary badge-pill">${newConfirmed}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Deaths
                    <span class="badge badge-primary badge-pill">${totalDeaths}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    New Deaths
                    <span class="badge badge-primary badge-pill">${newDeaths}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Total Recovered
                    <span class="badge badge-primary badge-pill">${totalRecovered}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    New Recovered
                    <span class="badge badge-primary badge-pill">${newRecovered}</span>
                </li>

            </ul>
        </div>
        <div class="col">
            Buraya grafik geceke
        </div>
    </div>
</div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h1 style="text-align: center">Turkey</h1>

            <ul class="list-group">

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Confirmed Cases
                    <span class="badge badge-primary badge-pill">${turkeyConfirmed}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Deaths
                    <span class="badge badge-primary badge-pill">${turkeyDeaths}</span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Recovered Cases
                    <span class="badge badge-primary badge-pill">${turkeyRecovered}</span>
                </li>

            </ul>
        </div>
        <div class="col-sm-8">
            <div>
                <canvas id="my1Chart" height="500"></canvas>
            </div>>
        </div>
    </div>
</div>

<script>

    var ctx1 = document.getElementById("my1Chart").getContext('2d');

    var graphDataYaxis = ${yAxis};
    var graphDataXaxis = [${xAxis}];

    console.log(graphDataYaxis);
    console.log(graphDataXaxis);

    var my1Chart = new Chart(ctx1, {
        type: 'line',
        data: {
            labels: graphDataXaxis,
            lineTension: 0.1,
            fill: true,
            datasets: [{
                label: 'Confirmed Cases Day By Day', // Name the series
                data: graphDataYaxis, // Specify the data values array
                fill: false,
                borderColor: '#2196f3', // Add custom color border (Line)
                backgroundColor: '#2196f3', // Add custom color background (Points and Fill)
                borderWidth: 3 // Specify bar border width
            }]},
        options: {
            responsive: true, // Instruct chart js to respond nicely.
            maintainAspectRatio: false, // Add to prevent default behaviour of full-width/heigh
            scales:{
                yAxes:[{
                    ticks:{
                        beginAtZero:true
                    }

                }

                ]
            }

        }
    });
</script>





