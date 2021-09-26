/**
 * function for processing the entered information and transforming the students table
 */
function getDataTable() {
    const table = document.getElementById("dataTable");
    const name = document.getElementById("name").value;
    const gender = document.getElementById("gender").value;
    const inputBornDate = document.getElementById("datePicker").value; //get date YYYY-DD-MM
    const transformedBornDate = inputBornDate.split('-').reverse().join('.'); //transform date: YYYY-DD-MM -> DD.MM.YYYY for print in table
    const ageCount = calculateAgeCount(inputBornDate);
    if (name) {
        let inputParams = [name, gender, transformedBornDate, ageCount];
        addNewRow(table, inputParams);
    } else {
        alert("Введите имя!");
    }
    calculateAverage();
}

/**
 *
 * function creates a new cell in the students table
 * find the first cell that does not contain data about the person
 * add a new cell to the table before the cell found in the previous step
 * @param table - students table
 * @param params - array with input parameters
 */
function addNewRow(table, params) {
    const newRow = document.createElement("tr");
    const tableColumnCount = getTableColumnCount(table);
    for (let i = 0; i < tableColumnCount; i++) {
        const newCell = document.createElement("td");
        //add class to cells classList, depending on cell number
        if (i === 0) {
            newCell.classList.add('firstColumn');
        } else if (i === tableColumnCount - 1) {
            newCell.classList.add('lastColumn');
        } else {
            newCell.classList.add('intermediateColumn');
        }
        newCell.innerHTML = params[i];
        newRow.appendChild(newCell);
    }
    let row = getFirstRowWithoutPersonData(table);
    row.before(newRow);
}

/**
 * function for get column count in students table
 * @param table - students table
 * @returns {number} - columnCount in table
 */
function getTableColumnCount(table) {
    let columnCount = 0;
    const rows = table.rows;
    if (rows.length > 0) {
        const cells = rows[0].cells;
        for (let i = 0; i < cells.length; ++i) {
            columnCount += cells[i].colSpan;
        }
    }
    return columnCount;
}

/**
 *
 * @param dateString - date in format date YYYY-DD-MM
 * @returns {number} - number of years calculated from date
 */
function calculateAgeCount(dateString) {
    const birthDay = new Date(dateString);
    return Math.floor((new Date() - new Date(birthDay)) / 1000 / 60 / 60 / 24 / 365);
}

/**
 *
 * @param table - students table
 * @returns {*} - first row without personal data
 */
function getFirstRowWithoutPersonData(table) {
    let columnCount = getTableColumnCount(table);
    let rowCount = table.rows.length;
    for (let i = 0; i < rowCount; i++) {
        if (table.rows[i].cells.length < columnCount) {
            return table.rows[i];
        }
    }
}

/**
 * function for calculate average of students age
 */
function calculateAverage() {
    //find a list of elements with a class that contains age values
    const classes = document.getElementsByClassName("lastColumn");
    let sum = 0;
    if (classes.length > 0) {
        for (let i = 0; i < classes.length; i++) {
            sum += Number(classes[i].innerHTML);
        }
    }
    let average = Math.floor(sum / classes.length);
    //find the target cell for write the value
    const targetCell = document.getElementById("middleAgeCount");
    //inserting a calculated value into the target cell
    targetCell.innerHTML = average.toString();
}