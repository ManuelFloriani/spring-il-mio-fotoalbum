// url settings
const apiUrl = 'http://localhost:8080/api/photos';

// root element
const root = document.getElementById("root");

// submit button
const submit = document.getElementById('button_search');
// input field
const input = document.getElementById('search');

// variables
let contentAlbum;
let contentSinglePhoto;
let infoPhoto;

// photo list function
const getPhotos = async (search) => {
    // if search is undefined, set it to empty string
    if (search == undefined) {
        search = "";
    }
    try {
        let response = await axios.get(apiUrl + '?search=' + search);
        renderPhotoList(response.data);
    } catch (e) {
        console.log(e);
    }
};

// render photo list
const renderPhotoList = (data) => {
    contentAlbum = "";
    if (data.length > 0) {
        data.forEach((element) => {
            contentSinglePhoto = renderPhoto(element);
            contentAlbum += contentSinglePhoto;
        });
    } else {
        contentAlbum = '<div class="alert alert-info" style="padding: 30px;">Portfolio is empty.</div>';
    }
    root.innerHTML = contentAlbum;
};

// render single photo
function renderPhoto(element) {
    infoPhoto = `
        <div class="card" style="width: calc(100% / 3 - 15px); height: 380px;">
            <img src="${element.imageUrl}" class="card-img-top" alt="${element.title}"
                style="max-height: 200px; object-fit: cover;">
            <div class="card-body">
                <h5 class="card-title">${element.title}</h5>
                <p class="card-text" style="overflow-y: auto; height: 60px;">${element.description}</p>
            </div>
        </div>`;
    return infoPhoto;
};

// search button function
submit.addEventListener('click', (event) => {
    event.preventDefault();
    getPhotos(input.value);
});


getPhotos();


const form = document.getElementById('formContact');

// onclick function
form.addEventListener('submit', async function (event) {
    event.preventDefault();

    // saving form data in variables
    const formData = new FormData(form);
    const emailForm = formData.get('emailForm');
    const bodyEmail = formData.get('bodyEmail');

    if (validateForm()) {
        // Json data
        const jsonData = {
            senderEmail: emailForm,
            body: bodyEmail,
        };

        const config = {
            headers: {
                'Content-Type': 'application/json',
            },
        };

        // Sending data to backend
        try {
            await axios.post(apiUrl + '/send', JSON.stringify(jsonData), config);
            window.location.href = '/index.html';
        } catch (error) {
            console.error(error);
        }
    }
});

function validateForm() {
    let isValid = true;

    // validation of the field "emailForm"
    const emailValue = emailForm.value.trim();
    if (emailValue === "") {
        isValid = false;
        document.getElementById("emailForm-error").innerHTML = "Email field is required.";
        emailForm.classList.add("is-invalid");
    } else if (!isValidEmail(emailValue)) {
        isValid = false;
        document.getElementById("emailForm-error").innerHTML = "Email is not valid.";
        emailForm.classList.add("is-invalid");
    } else {
        document.getElementById("emailForm-error").innerHTML = "";
        emailForm.classList.remove("is-invalid");
    }

    // validation of the field "bodyEmail"
    const nameValue = bodyEmail.value.trim();
    if (nameValue === "") {
        isValid = false;
        document.getElementById("bodyEmail-error").innerHTML = "Message field is required.";
        bodyEmail.classList.add("is-invalid");
    }
    else if (nameValue.length < 3) {
        isValid = false;
        document.getElementById("bodyEmail-error").innerHTML = "Message must be at least 3 characters long.";
        bodyEmail.classList.add("is-invalid");
    }
    else {
        document.getElementById("bodyEmail-error").innerHTML = "";
        bodyEmail.classList.remove("is-invalid");
    }

    return isValid;
}

function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}