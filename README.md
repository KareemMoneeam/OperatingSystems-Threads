# OperatingSystems-Threads
Given N numbers and one file, our system simulates a real-life of how buffering is run where a user will decide N to get the prime numbers from
0 to N. Somehow, the producer schedules the primes in a queue and consumer will use this queue to write them in the file, so do an 
application using multiple threads to do multiple actions simultaneously which will reduce the time elapsed.

Note: The Consumer thread will hold a lock when it start and release it when the 
ready queue is Empty and must notify all other threads.
