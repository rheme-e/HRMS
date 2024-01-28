# HRMS Projesi

Bu proje, insan kaynakları süreçlerini yönetmeyi amaçlayan kapsamlı bir sistemdir. İş arayanlar, iş verenler ve sistem personeli olmak üzere üç temel kullanıcı türüne sahiptir.

## Veritabanı Modellemesi

Proje için PostgreSQL veritabanı kullanılmaktadır. Veritabanı adı `hrms` olarak belirlenmiştir.

### İş Arayanlar

- Kullanıcı adı
- Soyadı
- TC Kimlik No
- Doğum Yılı
- E-Posta
- Şifre
- Şifre Tekrarı

### İş Verenler

- Şirket Adı
- Web Sitesi
- E-Posta
- Telefon
- Şifre
- Şifre Tekrarı

### İş Pozisyonları

- Pozisyon Adı

## Kullanıcı Kayıt ve Doğrulama

### İş Arayanlar

- Mernis doğrulaması yapılarak kayıt olunur.
- E-posta doğrulaması gereklidir.
- Daha önce kayıtlı e-posta veya TC Kimlik No kontrolü yapılır.

### İş Verenler

- E-posta doğrulaması gereklidir.
- HRMS personeli onayı gereklidir.
- Daha önce kayıtlı e-posta kontrolü yapılır.

## İş Pozisyonları

- Tekrar edilemeyen pozisyon adları eklenir.

## İş Verenler ve İş Arayanlar Listelenir

- Tüm liste olarak görüntülenebilir.

## İş İlanları

### İlan Ekleme

- Genel iş pozisyonu seçilebilir.
- İş tanımı girilebilir.
- Şehir bilgisi seçilebilir.
- Maaş skalası (opsiyonel)
- Açık pozisyon adedi girilebilir.
- Son başvuru tarihi belirtilebilir.

### İlan Listeleme

- Tüm aktif iş ilanları listelenebilir.
- Tarih sırasına göre filtreleme yapılabilir.
- Bir firmaya ait ilanlar görüntülenebilir.

### İlan Kapatma

- İş verenler sistemdeki bir ilanı kapatabilir.

## CV Girişi

- Okudukları okullar sisteme eklenebilir.
- Okudukları okullar mezuniyet yılına göre tersten sıralanır.
- İş tecrübeleri girebilirler.
- İş tecrübeleri yıla göre tersten sıralanır.
- Bildikleri yabancı dilleri sisteme ekleyebilirler.
- Fotoğraf, GitHub adresi, LinkedIn adresi ekleyebilirler.
- Bildikleri programlama dillerini veya teknolojilerini sisteme ekleyebilirler.
- Ön yazı ekleyebilirler.

## Dış Servis Entegrasyonu

- Fotoğraflar [Cloudinary](https://cloudinary.com/) sisteminde tutulacaktır.

## GitHub Adresi

Projenin GitHub adresi: [GitHub - HRMS Project](https://github.com/rheme-e/HRMS)

## Diğer Bilgiler

- Projede sahte servisler kullanılarak doğrulama işlemleri gerçekleştirilir.
- İsterler dışında kodlama yapılmamıştır.
