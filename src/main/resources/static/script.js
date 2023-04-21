function messagePopup() {
    let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=500, top=0,left=0";
    window.open('', 'messagePopup', options);

    var form = document.getElementById('hiddenForm');
    form.target = 'messagePopup';
    form.action = '/message/main';
    form.method = 'post';
    form.submit();
}

function messagePopup2(id, name, userId) {
    console.log("=======================");
    let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=500, top=0,left=0";
    window.open('', 'messagePopup', options);


    var form = document.createElement("form");
    form.setAttribute("target", "messagePopup");
    form.setAttribute("action", "/message/main");
    form.setAttribute("method", "post");

    var msg_id = document.createElement("input");
    msg_id.setAttribute("type", "hidden");
    msg_id.setAttribute("name", "receiverId");
    msg_id.setAttribute("value", id);
    form.appendChild(msg_id);

    var user_name = document.createElement("input");
    user_name.setAttribute("type", "hidden");
    user_name.setAttribute("name", "receiverName");
    user_name.setAttribute("value", name);
    form.appendChild(user_name);

    var user_id = document.createElement("input");
    user_id.setAttribute("type", "hidden");
    user_id.setAttribute("name", "receiverUserId");
    user_id.setAttribute("value", userId);
    form.appendChild(user_id);

    document.body.appendChild(form);
    form.submit();
}

function profileEdit() {
    let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=200, top=0,left=0";
    window.open('/mypage/profile/pic', '_blank', options);
}

function messageReadPopup(msgId, receiveChk) {
    let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=500, top=0,left=0";
    window.open('/message/popup/' + msgId +'/' + receiveChk, '_blank', options);
}

function memberPopup(memberId) {
    let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=400, height=500, top=0,left=0";
    window.open('/member/popup/' + memberId, '_blank', options);
}

function openTabContent(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function follow(btn,id) {
    var btn_id = btn.getAttribute('id');

    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    if (btn_id == 'follow')
        f.setAttribute('action', '/follow/follow/' + id);
    if (btn_id == 'unfollow')
        f.setAttribute('action', '/follow/unfollow/' + id);
    document.body.appendChild(f);
    f.submit();

    opener.parent.location.reload();
}

function quit() {
    window.close();
    opener.location.reload();
}
