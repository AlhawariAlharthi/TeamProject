function getInfo() {
	fetch('/student-lounge/GetInfo').then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("info").innerHTML = text;
		});
	});

}

function getBooks() {
	fetch('/student-lounge/GetBooksByUser').then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("books").innerHTML = text;
		});
	});
}

function getBook(id) {
	fetch('/student-lounge/GetBook?id=' + id).then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("book").innerHTML = text;
		});
	});
}

function deleteBook(id) {
	fetch('/student-lounge/Delete?id=' + id);
	getBooks();
}

function getAllBooks(id) {

	if (id == 2) {
		fetch('/student-lounge/GetAllBooks').then(function(response) {
			return response.text().then(function(text) {
				document.getElementById("allBooks").innerHTML = text;
			});
		});
	}
	else
		{
		var key = document.getElementById("keyword").value;
		fetch('/student-lounge/GetAllBooks?keyword=' + key).then(
				function(response) {
					return response.text().then(function(text) {
						document.getElementById("allBooks").innerHTML = text;
					});
				});
		}

}

