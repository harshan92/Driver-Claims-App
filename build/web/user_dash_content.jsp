<%-- 
    Document   : user_dash_conent
    Created on : Jul 15, 2018, 1:31:10 AM
    Author     : sean
--%>

<%@page import="Database.Entities.Members"%>
<!-- Banner -->
<section id="banner">
    <div class="content">
	<header>
            <h1><br />Rizni Rox</h1>
            <p>A free and fully responsive site template</p>
	</header>
	<p>Aenean ornare velit lacus, ac varius enim ullamcorper eu. Proin aliquam facilisis ante interdum congue. Integer mollis, nisl amet convallis, porttitor magna ullamcorper, amet egestas mauris. Ut magna finibus nisi nec lacinia. Nam maximus erat id euismod egestas. Pellentesque sapien ac quam. Lorem ipsum dolor sit nullam.</p>
	<ul class="actions">
            <li><a href="#" class="button big">Learn More</a></li>
	</ul>
    </div>
    <span class="image object">
	<img src="images/pic10.jpg" alt="" />
    </span>
</section>
<!-- Section -->
<section>
    <header class="major">
        <h2>Erat lacinia</h2>
    </header>
    <div class="features">
	<article>
            <span class="icon fa-diamond"></span>
            <div class="content">
		<h3>Portitor ullamcorper</h3>
		<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            </div>
	</article>
        <article>
            <span class="icon fa-paper-plane"></span>
            <div class="content">
                <h3>Sapien veroeros</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            </div>
        </article>
        <article>
            <span class="icon fa-rocket"></span>
            <div class="content">
                <h3>Quam lorem ipsum</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            </div>
        </article>
        <article>
            <span class="icon fa-signal"></span>
            <div class="content">
                <h3>Sed magna finibus</h3>
                <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            </div>
        </article>
    </div>
</section>

							<!-- Section -->
<section>
    <header class="major">
        <h2>Ipsum sed dolor</h2>
    </header>
    <div class="posts">
        <article>
            <a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
            <h3>Interdum aenean</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
        <article>
            <a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
            <h3>Nulla amet dolore</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
        <article>
            <a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
            <h3>Tempus ullamcorper</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
        <article>
            <a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
            <h3>Sed etiam facilis</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
        <article>
            <a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
            <h3>Feugiat lorem aenean</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
        <article>
            <a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
            <h3>Amet varius aliquam</h3>
            <p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="actions">
                <li><a href="#" class="button">More</a></li>
            </ul>
        </article>
    </div>
</section>

    </div>
</div>

<!-- Sidebar -->
<div id="sidebar">
    <div class="inner">
        <!-- Search -->
        <section id="search" class="alt">
            <form method="post" action="#">
                <input type="text" name="query" id="query" placeholder="Search" />
            </form>
        </section>

        <!-- Menu -->
        <nav id="menu">
            <header class="major">
                <h2>Menu</h2>
            </header>
            <ul>
                <%
                    Members member=(Members)session.getAttribute("Member");
                    session.setAttribute("Member", member);
                    %>
                <li><a href="index.html">Dashboard</a></li>
                <li><a href="user_dash_claims.jsp">Make Claims</a></li>
                <li><a href="user_dash_see_claims.jsp">See Claims</a></li>
                <li><a href="Elements.html">See Balance</a></li>
                <li><a href="make_payment.jsp">Make Payment</a></li>
            </ul>
        </nav>



        <!-- Section -->
        <section>
            <header class="major">
                <h2>Get in touch</h2>
            </header>
            <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="contact">
                <li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
                <li class="fa-phone">(000) 000-0000</li>
                <li class="fa-home">1234 Somewhere Road #8254<br />
                Nashville, TN 00000-0000</li>
            </ul>
        </section>