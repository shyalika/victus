<%@ taglib
    uri="http://java.sun.com/jsp/jstl/core"
    prefix="c"%>
<%@ taglib
    uri="http://java.sun.com/jsp/jstl/fmt"
    prefix="fmt"%>
<%@taglib
    uri="http://www.springframework.org/tags/form"
    prefix="form"%>
<!--
	Strata by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Victus</title>
<meta charset="utf-8" />
<meta
    name="viewport"
    content="width=device-width, initial-scale=1, user-scalable=no" />
<link
    rel="stylesheet"
    href="../assets/css/main.css" />
</head>
<body class="is-preload">
    <!-- Header -->
    <header id="header">
        <div class="inner">
            <a
                href="#"
                class="image avatar"><img
                src="../images/Victus-icon.png"
                alt="Speak" /></a>
            <h1>
                <strong>I am Victus</strong>, the family friendly<br /> smart kitchen solution<br />
                for your daily needs.
            </h1>
        </div>
    </header>
    <!-- Main -->
    <div id="main">
        <!-- One -->
        <section id="one">
            <header class="major">
                <h2>Here's what we found for you.</h2>
            </header>
        </section>
        <!-- Two -->
        <!-- Four -->
        <h2>${view.page.title}</h2>
        <p>${view.page.article.description}</p>
        <section>
            <h4>Ingredients</h4>
            <div class="row">
                <div class="col-6 col-12-xsmall">
                    <ul>
                        <c:forEach
                            items="${view.page.recipe.ingredients}"
                            var="item">
                            <li>${item}</li>
                        </c:forEach>
                    </ul>
                </div>
                <article class="col-6 col-12-xsmall work-item">
                    <img
                        src="${view.image}"
                        alt="" />
                </article>
            </div>
            <h4>Instructions</h4>
            <div class="row">
                <div class="col-12-small">
                    <ul class="alt">
                        <c:forEach
                            items="${view.page.recipe.steps}"
                            var="step">
                            <li>${step}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </section>
    </div>
    <!-- Footer -->
    <footer id="footer">
        <div class="inner">
            <ul class="icons">
                <li><a
                    href="#"
                    class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a
                    href="#"
                    class="icon brands fa-github"><span class="label">Github</span></a></li>
                <li><a
                    href="#"
                    class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
                <li><a
                    href="#"
                    class="icon solid fa-envelope"><span class="label">Email</span></a></li>
            </ul>
        </div>
    </footer>
    <!-- Scripts -->
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/jquery.poptrox.min.js"></script>
    <script src="../assets/js/browser.min.js"></script>
    <script src="../assets/js/breakpoints.min.js"></script>
    <script src="../assets/js/util.js"></script>
    <script src="../assets/js/main.js"></script>
</body>
</html>