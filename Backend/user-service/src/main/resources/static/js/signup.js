document.getElementById('signupForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const id = document.getElementById('id').value.trim();
    const firstname = document.getElementById('firstname').value.trim();
    const lastname = document.getElementById('lastname').value.trim();

    if (!id || !firstname || !lastname) {
        alert("Please fill in all fields.");
        return;
    }

    const message = `Signed up with ID: ${id}, Name: ${firstname} ${lastname}`;
    document.getElementById('message').textContent = message;

    // You could send the data to your backend here using fetch()
    console.log({ id, firstname, lastname });
});