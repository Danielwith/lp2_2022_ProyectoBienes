<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!----======== CSS ======== -->
<link rel="stylesheet" href="css/stylebar.css">

<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<nav class="sidebar close">
    <header>
      <div class="image-text">
        <span class="image">
          <!--<img src="logo.png" alt="">-->
        </span>

        <div class="text logo-text">
          <span class="name">Menu</span>
          <span class="profession">Gestion de Bienes</span>
        </div>
      </div>

      <i class='bx bx-chevron-right toggle'></i>
    </header>

    <div class="menu-bar">
      <div class="menu">
        <ul class="menu-links">
          <li class="nav-link">
            <a href="index.jsp">
              <i class='bx bx-home-alt icon'></i>
              <span class="text nav-text">Inicio</span>
            </a>
          </li>
		  <c:forEach items="${sessionScope.LISTA}" var="bean">
      			<li class="nav-link">
      				<a href="${bean.url}">
      					<i class='${bean.icon} icon'></i><!-- ICONOS EN BOXICONS AL SELECCIONAR COPIAR DE FONT LA CLASS-->
      					<span class="text nav-text">${bean.nombre}</span>
      				</a>
      			</li>
      		</c:forEach>
        </ul>
      </div>

      <div class="bottom-content">
        <li class="">
          <a href="ServletLogin?tipo=CERRAR">
            <i class='bx bx-log-out icon'></i>
            <span class="text nav-text">Cerrar Sesión</span>
          </a>
        </li>
          </div>
        </li>
      </div>
    </div>
</nav>
 <script>
    /* Nav */
    const body = document.querySelector('body'),
      sidebar = body.querySelector('nav'),
      toggle = body.querySelector(".toggle"),
      modeSwitch = body.querySelector(".toggle-switch"),
      modeText = body.querySelector(".mode-text");


    toggle.addEventListener("click", () => {
      sidebar.classList.toggle("close");
    })
    /* Fin Nav */
  </script>
</body>
</html>