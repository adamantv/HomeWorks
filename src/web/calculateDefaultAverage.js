//find a list of elements with a class that contains age values
const classes = document.getElementsByClassName("ageColumn");
let sum = 0;
if (classes.length > 0) {
 for (let i = 0; i < classes.length; i++) {
   sum += Number(classes[i].innerHTML);
 }
}
console.log("sum " + sum)
let average = Math.floor(sum / classes.length);
//find the target cell for write the value
const targetCell = document.getElementById("middleAgeCount");
//inserting a calculated value into the target cell
targetCell.innerHTML = average.toString();
