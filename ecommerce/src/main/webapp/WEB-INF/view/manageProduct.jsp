<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">

	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="alert alert-success alert-dismisible">
					<button type="button" class="close" data-dismiss="alert">&#10006;</button>
					${message}
				</div>
			</div>
		</div>
	</c:if>


	<div class="row">


		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">Product Management Panel</div>


				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/productadd" method="POST"
						enctype="multipart/form-data">


						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Brand</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Enter Quantity" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Upload a file</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}"
									itemLabel="name" itemValue="id" class="form-control" />

								<div class="text-right">
									<br />
									<sf:hidden path="id" />
									<sf:hidden path="code" />
									<sf:hidden path="supplier" />
									<sf:hidden path="active" />
									<button type="button" class="btn btn-warning btn-xs"
										data-toggle="modal" data-target="#myCategoryModal">Add
										New Category</button>
								</div>

							</div>
						</div>
						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">

								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class='col-xs-12'>
			<table id="productsTable"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>
						<th>Edit</th>
					</tr>
				</tfoot>
			</table>
		</div>



	</div>