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
// ===============================
// MODAL MEUS AGENDAMENTOS
// ===============================

const openAgendamentos = document.getElementById("open-agendamentos");
const closeAgendamentos = document.getElementById("close-agendamentos");
const agendamentosModal = document.getElementById("agendamentos-modal");

openAgendamentos.addEventListener("click", function (event) {
  event.preventDefault();

  agendamentosModal.classList.add("active");
});

closeAgendamentos.addEventListener("click", function () {
  agendamentosModal.classList.remove("active");
});

agendamentosModal.addEventListener("click", function (event) {
  if (event.target === agendamentosModal) {
    agendamentosModal.classList.remove("active");
  }
});
