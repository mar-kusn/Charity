var summaryBtn = document.querySelector("#summaryBtn");

summaryBtn.addEventListener( 'click', function() {
  const categories = document.querySelectorAll("#categories");
  const quantity = document.querySelector("#quantity").value;
  const institution = document.querySelector("#institution").nodeValue;
  const street = document.querySelector("#street").value;
  const city = document.querySelector("#city").value;
  const zipCode = document.querySelector("#zipCode").value;
  const pickUpDate = document.querySelector("#pickUpDate").value;
  const pickUpTime = document.querySelector("#pickUpTime").value;
  const pickUpComment = document.querySelector("#pickUpComment").value;

  document.querySelector("#summQuantity").innerHTML = quantity;
  document.querySelector("#summCategories").innerHTML = getSelectedCheckbox2ndChldValues("categories");
  document.querySelector("#summInstitutionName").innerHTML = getSelectedCheckbox2ndSibil1ChildVal("institution");
  document.querySelector("#summPickupStreet").innerHTML = street;
  document.querySelector("#summPickupCity").innerHTML = city;
  document.querySelector("#summPickupZipCode").innerHTML = zipCode;
  document.querySelector("#summPhone").innerHTML = '111222333';
  document.querySelector("#summPickupDate").innerHTML = pickUpDate;
  document.querySelector("#summPickupTime").innerHTML = pickUpTime;
  document.querySelector("#summPickUpComment").innerHTML = pickUpComment;

});

function getSelectedCheckboxValues(name) {
  const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
  let values = [];
  checkboxes.forEach((checkbox) => {
    values.push(checkbox.value);
  });
  return values;
}
function getSelectedCheckbox2ndChldValues(name) {
  const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
  let values = [];
  checkboxes.forEach((checkbox) => {
    values.push(checkbox.nextElementSibling.nextElementSibling.innerText);
  });
  return values;
}

function getSelectedCheckbox2ndSibil1ChildVal(name) {
  const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
  let values = [];
  checkboxes.forEach((checkbox) => {
    values.push(checkbox.nextElementSibling.nextElementSibling.firstElementChild.innerText);
  });
  return values;
}
