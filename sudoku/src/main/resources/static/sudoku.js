document.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('.sudoku-cell').forEach(cell => {
    cell.addEventListener('input', function () {
      this.value = this.value.replace(/[^1-9]/g, '');
    });

    function sendCellUpdate(eventType, cell) {
      fetch('/cell-update', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          event: eventType,
          id: cell.id,
          pos: cell.dataset.pos,
          valor: cell.value
        })
      }).then(() => {
        fetch('/board-json')
          .then(resp => resp.json())
          .then(data => {
            Object.keys(data).forEach(pos => {
              const input = document.querySelector(`#${data[pos].id}`);
              if (input) {
                input.value = data[pos].valor || '';
                if (data[pos].valid === false) {
                  input.classList.add('invalid-cell');
                } else {
                  input.classList.remove('invalid-cell');
                }
              }
            });
          });
      });
    }

    cell.addEventListener('keyup', function () {
      sendCellUpdate('keyup', this);
    });
  });

  // Botão Resolver
  document.getElementById('solve-button').addEventListener('click', function () {
    fetch('/solve', { method: 'POST' })
      .then(() => {
        fetch('/board-json')
          .then(resp => resp.json())
          .then(data => {
            Object.keys(data).forEach(pos => {
              const input = document.querySelector(`#${data[pos].id}`);
              if (input) {
                input.value = data[pos].valor || '';
                if (data[pos].isValid === false) {
                  input.classList.add('invalid-cell');
                } else {
                  input.classList.remove('invalid-cell');
                }
              }
            });
          });
      });
  });

  // Botão Limpar
  document.getElementById('reset-button').addEventListener('click', function () {
    fetch('/reset', { method: 'POST' })
      .then(() => {
        fetch('/board-json')
          .then(resp => resp.json())
          .then(data => {
            Object.keys(data).forEach(pos => {
              const input = document.querySelector(`#${data[pos].id}`);
              if (input) {
                input.value = '';
                input.classList.remove('invalid-cell');
              }
            });
          });
      });
  });
});