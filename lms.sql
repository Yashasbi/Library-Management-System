PGDMP                         x            LibraryManagementService    13.0    13.0 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16519    LibraryManagementService    DATABASE     v   CREATE DATABASE "LibraryManagementService" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
 *   DROP DATABASE "LibraryManagementService";
                postgres    false            �            1259    16523    bookinfo    TABLE       CREATE TABLE public.bookinfo (
    bookname character varying(20),
    booktitle character varying(20),
    bookauthor character varying(20),
    bookcategory character varying(20),
    isbnnumber uuid NOT NULL,
    totalbookavailable integer,
    totalbookbooked integer
);
    DROP TABLE public.bookinfo;
       public         heap    postgres    false            �            1259    16531    studentinfo    TABLE     �   CREATE TABLE public.studentinfo (
    studentid uuid,
    bookid uuid,
    bookcategory character varying,
    dateofissue timestamp without time zone,
    dateofreturn timestamp without time zone
);
    DROP TABLE public.studentinfo;
       public         heap    postgres    false            �          0    16523    bookinfo 
   TABLE DATA           �   COPY public.bookinfo (bookname, booktitle, bookauthor, bookcategory, isbnnumber, totalbookavailable, totalbookbooked) FROM stdin;
    public          postgres    false    200   �	       �          0    16531    studentinfo 
   TABLE DATA           a   COPY public.studentinfo (studentid, bookid, bookcategory, dateofissue, dateofreturn) FROM stdin;
    public          postgres    false    201   "
       &           2606    16527    bookinfo bookinfo_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.bookinfo
    ADD CONSTRAINT bookinfo_pkey PRIMARY KEY (isbnnumber);
 @   ALTER TABLE ONLY public.bookinfo DROP CONSTRAINT bookinfo_pkey;
       public            postgres    false    200            �   J   x�v�t�sv���z>
�A�A�pS���s]c�4]��D]KC�TS�4K�T�$�4NSN�=... 3�,      �   Y   x�3N4J�0L6�56���54LM�MLI6�5021JL642000�45H6171��(�����ٕ����@��H��L���
��bF�p1�=... i!}     