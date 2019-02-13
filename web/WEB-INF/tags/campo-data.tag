<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="value" required="false" %>
<label for="${id}">${label}</label>
<input type="text" id="${id}" name="${id}" value="${value}"/>
<script>
    $(function () {
        var inputNumbers = 0;
        $("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
        $("#${id}").keyup(function (event) {
            var dataArray = $(this).val();
        })
        $("#${id}").keypress(function (event) {
            if (isNaN(event.key) && event.key !== "Backspace" && event.key !== "Delete") {
                event.preventDefault()
            }
        });
        /*
        * faz controle seu o usuario colar conteudo no campo de texto.
        */
        $("#${id}").on("paste", function (e) {
            e.preventDefault();
            var contentClipboard = e.originalEvent.clipboardData.getData("text");
            var array = contentClipboard.split("");
            var dateContentValid = false;
            if (array.length === 10) {
                if (!isNaN(array[0]) &&
                    !isNaN(array[1]) &&
                    array[2] === "/" &&
                    !isNaN(array[3]) &&
                    !isNaN(array[4]) &&
                    array[5] === "/" &&
                    !isNaN(array[6]) &&
                    !isNaN(array[7]) &&
                    !isNaN(array[8]) &&
                    !isNaN(array[9])) {
                    dateContentValid = true;
                }

                if (dateContentValid) {
                    $(this).val(contentClipboard);
                }
            } else if (array.length === 8) {
                var i;
                var numbersForDateValid = true;
                for (i = 0; i < array.length; i++) {
                    if (isNaN(array[i])) {
                        numbersForDateValid = false;
                        break;
                    }
                }
                if (numbersForDateValid) {
                    var date = array[0] + array[1] + "/"
                        + array[2] + array[3] + "/" + array[4] + array[5] + array[6] + array[7];
                    $(this).val(date);
                }
            }
        });
    });
</script>