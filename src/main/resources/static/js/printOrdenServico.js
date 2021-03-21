console.log("Print ordem doc")

var doc = new jsPDF();
var specialElementHandlers = {
    '#editor': function (element, renderer) {
        return true;
    }
};

$('#cmd').click(function () {
    console.log("Print ordem")
    doc.fromHTML($('#content-to-print').html(), 0, 0, {
        'width': 170,
            'elementHandlers': specialElementHandlers
    });
    setTimeout(function () {
        doc.save('sample-file.pdf');
    }, 2000);
});
