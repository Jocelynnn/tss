/**
 * Panama-ajaxtools: panama_table
 * @version: 0.1 beta 1
 * @date: Oct 5th 2008
 * @author: yunyuaner
 * @contact: yunyuaner@gmail.com
 */
function SwitchToEditMode()
{
    var value = this.innerHTML;
    if (this.__mode == "plain")
    {
        this.__mode = "edit";
        var input = document.createElement("input");
        input.id = "__curr";
        input.type = "text";
        input.value = value;
        input.style.width = 60;
        input.style.height = 20;
        input.onblur = SwitchToPlainMode;
        this.replaceChild(input, this.firstChild);
        input.focus();
    }
}
function SwitchToPlainMode()
{
    var parent = this.parentNode;
    parent.innerHTML = this.value;
    parent.__mode = "plain";
}

function PanamaTableInit()
{    
    PanamaTableInvalidate();
}
function PanamaTableInvalidate()
{
    var pTable = document.getElementById("panama_table");
    var pTableRows = pTable.getElementsByTagName("tr");
    for (var i = 0; i < pTableRows.length; i++)
    {
        pTableCells = pTableRows[i].getElementsByTagName("td");
        pTableRows[i].className = i % 2 ? "panama_table_row_odd" : "panama_table_row_even";
        for (var j = 1; j < pTableCells.length; j++)
        {
            pTableCells[j].className = "panama_table_cell";
            pTableCells[j].onclick = SwitchToEditMode;
            if (pTableCells[j].__mode == null)
                pTableCells[j].__mode = "plain";
        }
    }
    /* Exclusive of checkbox filed */
    pTable.__cellsPerRow = 3;
}
function PanamaTableGetRowNodeFromCellElem(e)
{
    return e.parentNode.parentNode;
}
function PanamaTableDeleteRow()
{
    var pTable = document.getElementById("panama_table");
    var rowsToDel = new Array();
    var chkboxFileds_NoFiltered = pTable.getElementsByTagName("input");

    /* Select the rows to be delete */
    for (var i = 0, j = 0; i < chkboxFileds_NoFiltered.length; i++)
    {
        if (chkboxFileds_NoFiltered[i].type == "checkbox" && chkboxFileds_NoFiltered[i].checked)
        {
            rowsToDel[j++] = PanamaTableGetRowNodeFromCellElem(chkboxFileds_NoFiltered[i]);
            
        }
    }

    for (var k = 0; k < rowsToDel.length; k++)
    {
        /* Note: pTable.firstChild of pTable is tbody */
        pTable.firstChild.removeChild(rowsToDel[k]);
    }
    PanamaTableInvalidate();
}
function PanamaTableAppendRow()
{
    var pTable = document.getElementById("panama_table");
    var newRow = document.createElement("tr");
    var newCells = new Array();
    var cellInputs = new Array();

    var chkboxFiledContainer = document.createElement("td");
    var chkboxFiled = document.createElement("input");
    chkboxFiled.type = "checkbox";
    chkboxFiledContainer.appendChild(chkboxFiled);
    newRow.appendChild(chkboxFiledContainer);
    chkboxFiled.focus();
    
    for (var i = 0; i < pTable.__cellsPerRow; i++)
    {
        newCells[i] = document.createElement("td");
        newCells[i].__mode = "edit";
        cellInputs[i] = document.createElement("input");
        cellInputs[i].type = "text";
        cellInputs[i].style.width = 60;
        cellInputs[i].style.height = 20;
        newCells[i].appendChild(cellInputs[i]);
        newRow.appendChild(newCells[i]);
    }
    
    /* Note: pTable.firstChild of pTable is tbody */
    pTable.firstChild.appendChild(newRow);

    /* Rebuild table to set table style */
    PanamaTableInvalidate();
}
function PanamaTableSelAll()
{
    var cbList = document.getElementById("panama_table").getElementsByTagName("input");
    var status = this.checked ? false : true;
    for (var i = 0; i < cbList.length; i++)
        cbList[i].checked = status;    
    this.checked = status;
}
function PanamaTableSave()
{
    var pTable = document.getElementById("panama_table");
    var rows = pTable.getElementsByTagName("tr");
    
    /* Change new row from edit mode to plain mode */
    for (var i = 0; i < rows.length; i++)
    {
        cells = rows[i].getElementsByTagName("td");
        /* Skip the chkbox filed */
        for (var j = 1; j < cells.length; j++)
        {
            if (cells[j].firstChild.nodeName.toLowerCase() == "input")
            {
                /* FIXME: value may be null */
                cells[j].innerHTML = cells[j].firstChild.value;
                cells[j].__mode = "plain";
            }
        } 
    }
    
    /* Parse data in table */
    var tableTextList = new Array();
    for (i = 0; i < rows.length; i++)
    {
        var rowTextList = new Array();
        var cells = rows[i].getElementsByTagName("td");
        for (j = 1; j < cells.length; j++)
            rowTextList[j-1] = cells[j].innerHTML;
        tableTextList[i] = rowTextList;
    }
    var xmlDoc = "<panama-table>";
    xmlDoc += "<root>";
    for (var m = 0; m < tableTextList.length; m++)
    {
        xmlDoc += "<panama-row>"
        for (var n = 0; n < tableTextList[m].length; n++)
        {
            xmlDoc += "<panama-cell>" + tableTextList[m][n] + "</panama-cell>";
        }
        xmlDoc += "</panama-row>"
    }
    xmlDoc += "</root>";
    xmlDoc += "</panama-table>";
    /* Note: Encode string from iso-8859-1 to uri */
    xmlDoc = encodeURIComponent(xmlDoc);

    /* Post data to hidden iframe */
    var hiddenIframe = document.createElement("iframe");
    hiddenIframe.style.display = "none";
    hiddenIframe.src = "about:blank";
    hiddenIframe.id = "hiddenIframe"
    document.body.appendChild(hiddenIframe);
    var hiddenIframe = document.getElementById("hiddenIframe");
    var hiddenDocument = hiddenIframe.contentWindow.document;
    var hiddenSrc = "<html><body><form id='hiddenForm' name='hiddenForm' enctype='application/x-www-form-urlencoded'><input id='hiddenXMLTmpBox' name='hiddenXMLTmpBox' type='hidden' /></form></body></html>";
    hiddenDocument.open();
    hiddenDocument.write(hiddenSrc);
    hiddenDocument.close();
    var hiddenForm = hiddenDocument.getElementById("hiddenForm");
    var hiddenXMLTmpBox = hiddenDocument.getElementById("hiddenXMLTmpBox");
    hiddenXMLTmpBox.value = xmlDoc;
    hiddenForm.action = "/tss/action/autoSync.action";
    hiddenForm.submit();
}