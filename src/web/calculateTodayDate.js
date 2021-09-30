/**
 * script for calculate today date for the default calendar
 */
Date.prototype.toDateInputValue = (function () {
    const local = new Date(this);
    local.setFullYear(this.getFullYear() - 15);
    return local.toJSON().slice(0, 10);
});
document.getElementById("datePicker").value = new Date().toDateInputValue();