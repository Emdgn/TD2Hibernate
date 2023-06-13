<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

</head>
<body>
	<section style="background-color: #eee;">
		<div class="container py-5">
			<h4 class="text-center mb-5">
				<strong>Product listing</strong>
			</h4>

			<c:out value="${ listeU.size()-1 }"></c:out>
			<c:forEach var="i" begin="0" end="${ listeU.size()-1 }" step="3">

				<div class="row">
				<c:if test="${ i<listeU.size() }">
					<div class="col-lg-4 col-md-12 mb-4">
						<div class="bg-image hover-zoom ripple shadow-1-strong rounded">
							<img
								src="https://static.vecteezy.com/system/resources/previews/019/896/012/original/female-user-avatar-icon-in-flat-design-style-person-signs-illustration-png.png"
								class="w-100" /> <a href="#!">
								<div class="mask" style="background-color: rgba(0, 0, 0, 0.3);">
									<div
										class="d-flex justify-content-start align-items-start h-100">
										<h5>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i).login }</span>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i).getListeRoles().get(0).nomRole }</span>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i).getUtilisateurDetails().email }</span>
										</h5>
										
									</div>
									
									<a href="ModifierUtilisateur?id=${ listeU.get(i).idUtilisateur }"><button type="button" class="btn btn-warning">Modifier</button></a>
            						<a href="SupprimerUtilisateur?id=${ listeU.get(i).idUtilisateur }"><button type="button" class="btn btn-danger">Supprimer</button></a>
									
								</div>
								<div class="hover-overlay">
									<div class="mask"
										style="background-color: rgba(253, 253, 253, 0.15);"></div>
								</div>
								
							</a>
						</div>
						
					</div>
					</c:if>

					<c:if test="${ i+1<listeU.size() }">
						<div class="col-lg-4 col-md-12 mb-4">
						<div class="bg-image hover-zoom ripple shadow-1-strong rounded">
							<img
								src="https://png.pngtree.com/png-vector/20190710/ourmid/pngtree-user-vector-avatar-png-image_1541962.jpg"
								class="w-100" /> <a href="#!">
								<div class="mask" style="background-color: rgba(0, 0, 0, 0.3);">
									<div
										class="d-flex justify-content-start align-items-start h-100">
										<h5>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+1).login }</span>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+1).getListeRoles().get(0).nomRole }</span>
											<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+1).getUtilisateurDetails().email }</span>
										</h5>
									</div>
								</div>
								<div class="hover-overlay">
									<div class="mask"
										style="background-color: rgba(253, 253, 253, 0.15);"></div>
								</div>
							</a>
						</div>
					</div>
					</c:if>

					<c:if test="${ i+2<listeU.size() }">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="bg-image hover-zoom ripple shadow-1-strong rounded">
								<img
									src="data:image/jpeg;base64,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"
									class="w-100" /> <a href="#!">
									<div class="mask" style="background-color: rgba(0, 0, 0, 0.3);">
										<div
											class="d-flex justify-content-start align-items-start h-100">
											<h5>
												<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+2).login }</span>
												<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+2).getListeRoles().get(0).nomRole }</span>
												<span class="badge bg-light pt-2 ms-3 mt-3 text-dark">${ listeU.get(i+2).getUtilisateurDetails().email }</span>
											</h5>
										</div>
									</div>
									<div class="hover-overlay">
										<div class="mask"
											style="background-color: rgba(253, 253, 253, 0.15);"></div>
								</a>
							</div>
						</div>
					</c:if>
		</div>

		</c:forEach>
		</div>
	</section>

</body>
</html>