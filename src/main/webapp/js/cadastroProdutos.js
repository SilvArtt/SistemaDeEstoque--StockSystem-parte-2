/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.getElementById("valor").addEventListener("input", calcular());
document.getElementById("quantidade").addEventListener("input", calcular());

function calcular(){
    let valor = parseFloat(document.getElementById("valor").value || 0 );
    let quantidade = parseInt(document.getElementById("quantidade").value || 0);
    
    document.getElementById("total").value = (valor * quantidade).toFixed();
}

