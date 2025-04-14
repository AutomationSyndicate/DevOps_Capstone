const urlParams = new URLSearchParams(window.location.search);
if (urlParams.has('error')) {
    document.getElementById('errorMessage').style.display = 'block';
}