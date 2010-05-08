activitycreator ../AndroidManifest.xml
ant release
jarsigner -verbose -keystore ./keystore bin/AddressBookActivity-unsigned.apk rterm
jarsigner -verbose -verify bin/AddressBookActivity-unsigned.apk 
mv bin/AddressBookActivity-unsigned.apk rterm-1.x.x.apk
./clean.sh
