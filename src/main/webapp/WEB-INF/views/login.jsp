<%--
  Created by IntelliJ IDEA.
  User: justyna
  Date: 26.10.2020
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form class="padding-small text-center" method="post" action="http://localhost:8080/login">
                    <h1 class="text-color-darker">Logowanie</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" name="email" placeholder="podaj adres email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                </form>
            </div>
        </div>
    </div>
</section>

</body>
</html>