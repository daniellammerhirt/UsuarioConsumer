const cpf = document.getElementById("cpf");

cpf.addEventListener("input", (e) => {
    let numeros = e.target.value.replace(/\D/g, "");

    numeros = numeros.replace(/(\d{3})(\d)/, "$1.$2");
    numeros = numeros.replace(/(\d{3})(\d)/, "$1.$2");
    numeros = numeros.replace(/(\d{3})(\d{1,2})$/, "$1-$2");

    e.target.value = numeros;
})