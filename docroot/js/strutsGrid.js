/*
 * Format a Column as Link
 */
function formatLink(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog("+cellvalue+")'>" + cellvalue + "</a>";
}

/*
 * Format a Column as Image
 */
function formatImage(cellvalue, options, row) {
	return "<img src='"+ context_path +"/images/page_edit.png' onClick='$.publish("+"&apos;edit_bookmark&apos;, {old_name:" +"&apos;"+cellvalue+"&apos;"+ "})' />";
}

