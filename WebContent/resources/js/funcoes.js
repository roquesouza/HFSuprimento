var win = null;

function Mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function Integer(v) {
	return v.replace(/\D/g, "");
}

