$(function () {

    $("#tabs").hide();
    $('#btnAddTextBox').on('click', function () {
        console.log($('#txtTeamSize'));
        console.log(parseInt($('#txtTeamSize').val()));

        for (var i = 0; i < parseInt($('#txtTeamSize').val()) ; i++) {
            $('<div class="row" style="padding:5px"><input type="text" style="height: 38px; width: 243px;" placeholder ="Enter Team Name.."/></div>').appendTo('#TeamNamesDiv').hide().fadeIn(4000);
        }

        $('<div class="row" style="padding:5px"><a href="#" id="btnAdd" style="width: 243px;" class="btn btn-default btn"><i class="fa fa-plus"></i>&nbsp;Create Teams</a><div').appendTo('#TeamNamesDiv').hide().fadeIn(4000);

    });


    $('body').on('click', '#btnAdd', function () {

        $("#tabs").show();
        $("#chennaiTab").trigger('click');
        $("#bloreTab").trigger('click');
        //$("#TeamNamesDiv input:text").each(function () {
        //    $('<li><a href="#tab_' + $(this).val().trim() + '" data-toggle="tab"> ' + $(this).val().trim() + '</a></li>').appendTo('#tabs');

        //    // create the tab content
        //    $('<div class="tab-pane" id="tab_' + $(this).val().trim() + '">' + $(this).val().trim() + ' content</div>').appendTo('.tab-content');
        //});
        //// make the new tab active
        //$('#tabs a:last').tab('show');

        $('#lnkAuction').trigger('click');

    });



    var totaltime = 10;
    function update(percent) {
        var deg;
        if (percent < (totaltime / 2)) {
            deg = 90 + (360 * percent / totaltime);
            $('.pie').css('background-image',
                      'linear-gradient(' + deg + 'deg, transparent 50%, white 50%),linear-gradient(90deg, white 50%, transparent 50%)'
                     );
        } else if (percent >= (totaltime / 2)) {
            deg = -90 + (360 * percent / totaltime);
            $('.pie').css('background-image',
                  'linear-gradient(' + deg + 'deg, transparent 50%, #008b9d 50%),linear-gradient(90deg, white 50%, transparent 50%)'
                 );
        }
    }

    $('#btnStartAuction').click(function () {

        var count = parseInt($('#time').text());
        myCounter = setInterval(function () {
            count += 1;
            $('#time').html(count);
            update(count);

            if (count == totaltime) {
               
                $('#myModel').modal('show');
                clearInterval(myCounter)
            };
        }, 1000);
    });

  
});