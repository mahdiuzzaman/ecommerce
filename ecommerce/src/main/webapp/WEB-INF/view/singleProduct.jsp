<div class="container">
	<!--Breadcrumb-->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">
		<!-- display product image -->
		<div class="col-sm-4 col-xs-12">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive">
			</div>
		</div>
		<!-- display product thumbnail -->
		<div class="col-sm-4 col-xs-12">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr>
			<h4>
				<strong>&#2547; ${product.unitPrice} /-</strong>
			</h4>
			<hr>
			<h6>In Stock: ${product.quantity}</h6>
			<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success"><span
				class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a> <a
				href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>
	</div>
</div>