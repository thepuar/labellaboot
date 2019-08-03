/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *$(document).ready(function() {
 *    $('#dataTable').DataTable();
 *} );
 */
$(document).ready(function () {
    $('#dataTable').DataTable({
        initComplete: function () {
            this.api().columns().every(function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                        .appendTo($(column.footer()).empty())
                        .on('change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                    $(this).val()
                                    );

                            column
                                    .search(val ? '^' + val + '$' : '', true, false)
                                    .draw();
                        });

                column.data().unique().sort().each(function (d, j) {
                    select.append('<option value="' + d + '">' + d + '</option>')
                });
            });
        }
    });
    $(function () {
         $('#fecha').datepicker({
            format: 'dd/mm/yyyy',
            weekStart: 1,
            calendarWeeks: true,
            todayHighlight: true,
            daysOfWeekDisabled:[0],
            autoclose: true
        });
    });
});

                       