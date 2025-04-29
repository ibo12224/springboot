function check() {
    const form = document.simpleboard;

    if (form.writer.value === "") {
        alert("작성자를 입력하세요.");
        form.writer.focus();
        return false;
    }

    if (form.title.value === "") {
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
    }

    if (form.content.value === "") {
        alert("내용을 입력하세요.");
        form.content.focus();
        return false;
    }

    return true; // 유효성 통과하면 submit 진행
}