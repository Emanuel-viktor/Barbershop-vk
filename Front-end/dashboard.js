const openButton = document.getElementById("open-agendamento");
const closeButton = document.getElementById("close-agendamento");
const modal = document.getElementById("agendamento-modal");

openButton.addEventListener("click", function (event) {
  event.preventDefault();

  modal.classList.add("active");
});

closeButton.addEventListener("click", function () {
  modal.classList.remove("active");
});

modal.addEventListener("click", function (event) {
  if (event.target === modal) {
    modal.classList.remove("active");
  }
});
