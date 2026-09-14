const form = document.getElementById("cadastro-form");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const telephone = document.getElementById("telephone").value;

  console.log({
    name,
    email,
    password,
    telephone,
  });

  alert("Cadastro realizado com sucesso!");
});
