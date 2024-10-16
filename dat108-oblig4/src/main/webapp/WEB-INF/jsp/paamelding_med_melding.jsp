<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <meta charset="UTF-8">
<!-- <script src="js/myscript.js" defer></script>  -->  
    <title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>
    <p style="color:red;">Påmeldingsdetaljer er ugyldige</p>
    
    <fieldset>
        <form>
            <label for="fornavn">Fornavn</label><br>
            <input type="text" name="fornavn"><br>
            <label for="etternavn">Etternavn</label><br>
            <input type="text" name="etternavn"><br>
            <label for="mobil">Mobil (8 siffer)</label><br>
            <input type="number" name="mobil"><br>
            <label for="passord">Passord</label><br>
            <input type="password" name="passord"><br>
            <label for="passordRepetert">Passord repetert</label><br>
            <input type="password" name="passordRepetert"><br>
            <label for="kjonn">Kjønn</label><br>
            <input type="radio" name="kjonn" value="mann">Mann
            <input type="radio" name="kjonn" value="kvinne">Kvinne<br>
            <input type="submit" value="Meld meg på">
        </form>   
    </fieldset>
    

</body>
</html>
