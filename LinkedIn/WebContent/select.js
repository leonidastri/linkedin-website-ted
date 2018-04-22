var dataTable = document.getElementById('data-table');
var checkItAll = dataTable.querySelector('input[name="select_all"]');
var inputs = dataTable.querySelectorAll('tbody>tr>td>input');
 
 
inputs.forEach(function(input) {
  input.addEventListener('change', function() {
    if (!this.checked) {
      checkItAll.checked = false;
    }else if (!checkItAll.checked) {
      var allChecked = true;
      for (var i=0; i<inputs.length; i++) {
        if (!inputs[i].checked) {
          allChecked = false;
          break;
        }
      }
     
      if (allChecked) {
        checkItAll.checked = true;
      }
    }
  });
});
 
checkItAll.addEventListener('change', function() {
  inputs.forEach(function(input) {
    input.checked = checkItAll.checked;
  });
});
