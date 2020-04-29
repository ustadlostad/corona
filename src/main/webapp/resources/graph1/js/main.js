const CHART = document.getElementById("lineChart");

let lineChart = new Chart(CHART,{
    type: 'line',
    data: {
        labels: ["January", "February", "March", "April", "May", "June", "July","August"],
        datasets: [
            {
                label: "My First dataset",
                fill: false,
                lineTension: 0.1,
                backgroundColor: "rgba(75, 192, 192, 0.4)",
                borderColor: "rgba(75, 192, 192, 1)",
                borderCapStyle: 'butt',
                borderDash: [],
                borderDashOffset: 0.0,
                borderJoinStyle: 'miter',
                pointBorderColor: "rgba(75,192,192,1)",
                pointBackgroundColor: "#fff",
                pointBorderWidth: 1,
                pointHoverRadius: 5,
                pointHitRadius: 10,
                data: [65, 59, 80, 81, 56, 55, 40,99],
            },
            {
                label: "My Second dataset",
                fill: true,
                lineTension: 0.5,
                backgroundColor: "rgba(75, 75, 192, 0.4)",
                borderColor: "rgba(75, 72, 192, 1)",
                borderCapStyle: 'butt',
                borderDash: [],
                borderDashOffset: 0.0,
                borderJoinStyle: 'miter',
                pointBorderColor: "rgba(75,72,192,1)",
                pointBackgroundColor: "#fff",
                pointBorderWidth: 1,
                pointHoverRadius: 5,
                pointHitRadius: 10,
                data: [35, 45, 55, 65, 75, 85, 40],
            }
        ]
    },
    options:{
        showLines:true,
        scales:{
            yAxes:[{
                ticks:{
                    beginAtZero:true,
                }
            }]
        }
    }
});