console.log("Print ordem doc")

var doc = new jsPDF();
var specialElementHandlers = {
    '#editor': function (element, renderer) {
        return true;
    }
};

$('#generatePDF').click(function () {

    doc.setFont('courier')

    var serviceOrderId  = $('#serviceOrderId').val();
    var userSelect      = $('#userSelect').val();
    var descriptionText = $('#descriptionText').val();
    var equipmentText   = $('#equipmentText').val();
    var statusSelect    = $('#statusSelect').val();

    var pdfData =  serviceOrderId + userSelect + descriptionText + equipmentText + statusSelect ;

    doc.setFontSize(20)
    doc.setFontType('bold')
    doc.text(20, 10, "DH INFO - ORDEM DE SERVIÇO")

    doc.setFontSize(16)

    doc.setFontType('bold')
    doc.text(20, 30, "Cliente")
    doc.setFontType('normal')
    doc.text(20, 40, userSelect)

    doc.setFontType('bold')
    doc.text(20, 60, "Número da OS")
    doc.setFontType('normal')
    doc.text(20, 70, serviceOrderId)

    doc.setFontType('bold')
    doc.text(20, 90, "Situação")
    doc.setFontType('normal')
    doc.text(20, 100, statusSelect)

    doc.setFontType('bold')
    doc.text(20, 120, "Descrição")
    doc.setFontType('normal')
    doc.text(20, 130, descriptionText)

    doc.setFontType('bold')
    doc.text(20, 150, "Equipamentos")
    doc.setFontType('normal')
    doc.text(20, 160, equipmentText)


    // generate pdf
    setTimeout(function () {
        doc.save('ordem-servico-dh-info.pdf');
    }, 2000);
});
