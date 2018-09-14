$(function() {
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	default:
		$('#home').addClass('active');
		break;
	}
	
	
	// code for jQuery data

	
	
	var $table = $("#productListTable")
	
	
	if($table.length){
		
		//console.log('insile the table')
		
		
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
			//lengthMenu
			//pageLength
			//data: products
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"  class="dataTableImage">';
					}
						
				},
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data:'unitPrice',
					mRender: function(data, type, row){
							return '&#2547; ' +data
						}
				},
				{
					data:'quantity'
				},
				{
					data:'id',
					bSortable: false,
					mRender: function(data, type, row){
						var str='';
						str+='<a href="'+window.contextRoot +'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
						str+='<a href="'+window.contextRoot +'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						return str;
					}
						
				}
				
			]
		});
	}

});















