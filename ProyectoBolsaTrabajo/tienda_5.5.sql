
CREATE TABLE rol (
  rol_nombre VARCHAR(20) NOT NULL,
  descripcion VARCHAR(64) NULL,
  PRIMARY KEY(rol_nombre)
);

CREATE TABLE usuario (
  id_usuario VARCHAR(20) NOT NULL,
  clave VARCHAR(20) NULL,
  nombres VARCHAR(64) NULL,
  paterno VARCHAR(32) NULL,
  materno VARCHAR(32) NULL,
  correo VARCHAR(64) NULL,
  direccion VARCHAR(128) NULL,
  telefono VARCHAR(32) NULL,
  estado CHAR(1) NULL,
  PRIMARY KEY(id_usuario)
);

CREATE TABLE categoria (
  id_categoria INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NULL,
  descripcion VARCHAR(64) NULL,
  PRIMARY KEY(id_categoria)
);

CREATE TABLE producto (
  id_producto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_categoria INTEGER UNSIGNED NOT NULL,
  nombre VARCHAR(128) NULL,
  descripcion VARCHAR(256) NULL,
  precio DECIMAL NULL,
  stock INTEGER UNSIGNED NULL,
  importancia INTEGER UNSIGNED NULL,
  imagen VARCHAR(20) NULL,
  PRIMARY KEY(id_producto),
  FOREIGN KEY(id_categoria)
    REFERENCES categoria(id_categoria)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE pedido (
  id_pedido INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_usuario VARCHAR(20) NOT NULL,
  fecha DATETIME NULL,
  estado CHAR NULL,
  total DOUBLE NULL,
  PRIMARY KEY(id_pedido),
  FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE usuario_rol (
  rol_nombre VARCHAR(20) NOT NULL,
  id_usuario VARCHAR(20) NOT NULL,
  FOREIGN KEY(id_usuario)
    REFERENCES usuario(id_usuario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(rol_nombre)
    REFERENCES rol(rol_nombre)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE detalle_pedido (
  id_detalle_pedido INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_pedido INTEGER UNSIGNED NOT NULL,
  id_producto INTEGER UNSIGNED NOT NULL,
  precio DOUBLE NULL,
  cantidad INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_detalle_pedido, id_pedido),
  FOREIGN KEY(id_pedido)
    REFERENCES pedido(id_pedido)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(id_producto)
    REFERENCES producto(id_producto)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);




insert  into `categoria`(`id_categoria`,`nombre`,`descripcion`) values (1,'Libros','Categoria de libros');


insert  into `producto`(`id_producto`,`id_categoria`,`nombre`,`descripcion`,`precio`,`stock`,`importancia`,`imagen`) values (1,1,'2 años de vacaciones','Libro muy interesante','35',3,1,NULL),(2,1,'La casa verde','De Mario Vargas LLosa','33',5,2,NULL);




insert  into `rol`(`rol_nombre`,`descripcion`) values ('admin','rol de admin'),('ventas','rol de ventas');



insert  into `usuario`(`id_usuario`,`clave`,`nombres`,`paterno`,`materno`,`correo`,`direccion`,`telefono`,`estado`) values ('david','123','David','Rodriguez','Condezo','rcondezo@gmail.com','desconocido','1324','1');



insert  into `usuario_rol`(`rol_nombre`,`id_usuario`) values ('admin','david');

