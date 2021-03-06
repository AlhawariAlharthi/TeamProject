function getInfo() {
	fetch('/student-lounge/GetInfo').then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("info").innerHTML = text;
		});
	});

}

function getBooks() {
	fetch('/student-lounge/GetBook?fun=getBooksByUser').then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("books").innerHTML = text;
		});
	});
}

function getBook(id) {
	fetch('/student-lounge/GetBook?id=' + id + '&fun=getBook').then(function(response) {
		return response.text().then(function(text) {
			document.getElementById("book").innerHTML = text;
		});
	});
}

function deleteBook(id) {
	var r = confirm('Are you sure you want to delete this book?');

	if (r == true) {
		fetch('/student-lounge/Delete?id=' + id);
	}

	getBooks();
}

function getAllBooks() {
	var key;
	try {
		key = document.getElementById("keyword").value;

		fetch('/student-lounge/GetBook?keyword=' + key + '&fun=getAllBooks').then(
				function(response) {
					return response.text().then(function(text) {
						console.log(text);
						document.getElementById("allBooks").innerHTML = text;
					});
				});
	} catch (error) {
		fetch('/student-lounge/GetBook' + '&fun=getAllBooks').then(function(response) {
			return response.text().then(function(text) {
				console.log(text);
				document.getElementById("allBooks").innerHTML = text;
			});
		});
	}

}

function imgurl() {

}