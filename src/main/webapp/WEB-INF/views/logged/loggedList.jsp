<%--
  Created by IntelliJ IDEA.
  User: justyna
  Date: 27.10.2020
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logged/dashboard" />">
            <span>Pulpit</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logged/drinks" />">
            <span>Drinki</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/logged/edituser" />">
            <span>Edytuj dane</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="/editPassword">
            <span>Zmień hasło</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">

    </li>
</ul>