const chatbotButton = document.getElementById("chatbotButton");
const chatbot = document.getElementById("chatbot");
const closeButton = document.getElementById("closeButton");

const sendButton = document.getElementById("sendButton");
const userInput = document.getElementById("userInput");
const messages = document.getElementById("messages");


/* ABRIR CHATBOT */
chatbotButton.addEventListener("click", function () {
    chatbot.style.display = "flex";
});


/* CERRAR CHATBOT */
closeButton.addEventListener("click", function () {
    chatbot.style.display = "none";
});


/* ENVIAR MENSAJE */
sendButton.addEventListener("click", handleMessage);


/* ENVIAR CON ENTER */
userInput.addEventListener("keypress", function (event) {

    if (event.key === "Enter") {
        handleMessage();
    }

});


/* PROCESAR MENSAJE */
function handleMessage() {

    const text = userInput.value.trim();

    if (text === "") {
        return;
    }

    /* Mostrar mensaje del usuario */
    addMessage(text, "user");

    /* Limpiar campo */
    userInput.value = "";

    /* Responder */
    setTimeout(function () {

        const response = getBotResponse(text);

        addMessage(response, "bot");

    }, 400);
}


/* AGREGAR MENSAJE AL CHAT */
function addMessage(text, type) {

    const message = document.createElement("div");

    message.classList.add("message", type);

    message.textContent = text;

    messages.appendChild(message);

    messages.scrollTop = messages.scrollHeight;
}


function getBotResponse(question) {

    const pregunta = question
        .toLowerCase()
        .normalize("NFD")
        .replace(/[\u0300-\u036f]/g, "");


    if (pregunta.includes("evohka") || pregunta.includes("proyecto")) {

        return "EVOHKA es una plataforma inmobiliaria que permite consultar propiedades y gestionar solicitudes de alquiler.";
    }


    if (
        pregunta.includes("registro") ||
        pregunta.includes("registrar") ||
        pregunta.includes("cuenta")
    ) {

        return "Para utilizar EVOHKA puedes registrarte creando una cuenta y seleccionando el tipo de usuario correspondiente.";
    }


    if (
        pregunta.includes("publicar") ||
        pregunta.includes("propietario") ||
        pregunta.includes("inmueble")
    ) {

        return "Si eres propietario, puedes publicar una propiedad agregando información como ubicación, precio, características y fotografías.";
    }


    if (
        pregunta.includes("buscar") ||
        pregunta.includes("arrendar") ||
        pregunta.includes("alquilar") ||
        pregunta.includes("vivienda") ||
        pregunta.includes("propiedad")
    ) {

        return "Puedes consultar las propiedades disponibles y buscar una vivienda de acuerdo con tus necesidades.";
    }


    if (
        pregunta.includes("solicitud") ||
        pregunta.includes("solicitar") ||
        pregunta.includes("alquiler")
    ) {

        return "Cuando encuentres una propiedad que te interese, puedes realizar una solicitud de alquiler para que sea gestionada por EVOHKA.";
    }


    if (
        pregunta.includes("tecnologia") ||
        pregunta.includes("tecnologias") ||
        pregunta.includes("desarrollo")
    ) {

        return "Este chatbot básico fue desarrollado utilizando HTML, CSS y JavaScript.";
    }


    return "Disculpa, todavía no tengo una respuesta para esa pregunta. Puedes preguntarme sobre EVOHKA, registro, propiedades, alquileres o solicitudes.";
}