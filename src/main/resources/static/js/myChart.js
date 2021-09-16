
var newchartData = decodeHtml(chartData);
let chartJSONArray = JSON.parse(newchartData);

var arrayLength = chartJSONArray.length;


var numericData =[];
var labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] =  chartJSONArray[i].value;
    labelData[i]  = chartJSONArray[i].label;
    
}


new Chart(document.getElementById("myPieChart"),{
    type: 'pie',

        data: {
            labels: labelData,
            datasets: [{
                label: "My First dataset",
                backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
                data: numericData,
            }]
        },


        options: {

        title:{
            display: true,
            text: 'Project Status'
        }

        }

});

// converting from cryptic to String
function decodeHtml(html){
    let txt = document.createElement("textarea");

    txt.innerHTML = html;

    return txt.value;


}