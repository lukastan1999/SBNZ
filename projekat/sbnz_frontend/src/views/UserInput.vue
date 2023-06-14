<template>

  <div class="container">

    <div class="left-section">
      <!-- W E A T H E R  C O N D I T I O N  -->
      <h1>Enter Conditions</h1>
      <br/>

      <div class="button-container">
        <h2>Weather:</h2>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: weatherCondition === 'sunny' }"
          @click="handleButtonClickWeather('sunny')"
        >
          Sunny
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: weatherCondition === 'cloudy' }"
          @click="handleButtonClickWeather('cloudy')"
        >
          Cloudy
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: weatherCondition === 'rain' }"
          @click="handleButtonClickWeather('rain')"
        >
          Rain
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: weatherCondition === 'nightfall' }"
          @click="handleButtonClickWeather('nightfall')"
        >
          Nightfall
        </button>
      </div>

      <!-- D E P T H   O F   F I E L D -->
      <div class="button-container">
        <h2> Depth of Field:</h2>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: depthOfField === 'macro' }"
          @click="handleButtonClickDepthoffield('macro')"
        >
          Macro
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: depthOfField === 'portrait' }"
          @click="handleButtonClickDepthoffield('portrait')"
        >
          Portrait
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: depthOfField === 'landscape' }"
          @click="handleButtonClickDepthoffield('landscape')"
        >
          Landscape
        </button>
      </div>

      <!-- S U B J E C T   M O V E M E N T -->
      <div class="button-container">
        <h2>Subject Movement:</h2>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: subjectMovement === 'static' }"
          @click="handleButtonClickSubjectmovement('static')"
        >
          Static
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: subjectMovement === 'slightMovement' }"
          @click="handleButtonClickSubjectmovement('slightMovement')"
        >
          Slight Movement
        </button>
        <button
          type="button"
          class="btn btn-primary btn-lg"
          :class="{ active: subjectMovement === 'rapidMovement' }"
          @click="handleButtonClickSubjectmovement('rapidMovement')"
        >
          Rapid Movement
        </button>
      </div>

      <br/>
      <br/>
      <button type="button" class="btn btn-custom  btn-lg btn-block" @click="handleSEND">Send</button>

    </div>

    <div class="right-section">
      <!-- Display received data -->
      <div v-if="receivedData">
        <h1>Suggested properties for your conditions:</h1>
        <br/>
        <h2>Aperture: {{ receivedData.aperture }}</h2>
        <h2>Shutter Speed: {{ receivedData.shutterSpeed }}</h2>
        <h2>ISO: {{ receivedData.iso }}</h2>
        <br/>
        <button type="button" class="btn btn-custom  btn-lg btn-block" @click="handleReload">RESET</button>
      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'UserInput',
  data() {
    return {
      weatherCondition: null,
      depthOfField: null,
      subjectMovement: null,
      receivedData: null,
    }
  },
  methods: {
    handleButtonClickWeather(button) {
      this.weatherCondition = button;
    },
    handleButtonClickDepthoffield(button) {
      this.depthOfField = button;
    },
    handleButtonClickSubjectmovement(button) {
      this.subjectMovement = button;
    },
    handleSEND() {

      if (this.weatherCondition===null || this.depthOfField===null || this.subjectMovement===null) {
        alert("You must enter all fields");
      }

      let jsonData = {
        'weatherCondition': this.weatherCondition,
        'depthOfField': this.depthOfField,
        'subjectMovement': this.subjectMovement,
      };

      axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
      axios.defaults.headers.common['Content-Type'] = 'application/json';
      // axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.$store.getters.accessToken;
      axios.post('/api/photography/configure', jsonData)
        .then((response) => {
          this.receivedData = response.data;

        }).catch((err) => {
          alert("There has been a mistake.");
          // alert(err.response.data.message);
          console.log(err.response.data.message);

        });

    },
    handleReload() {
      location.reload();
    }
  },
}
</script>

<style scoped>


.left-section {
  width: 50%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.right-section {
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container {
  /* position: fixed; */
  display: flex;
  /* justify-content: space-between; */
  justify-content: center;
  align-items: center;
  padding: 20px;
  /* flex-direction: column;
  align-items: center; */
  height: 100vh; /* Adjust the value if needed */
  overflow: hidden;
  text-align: center; /* Center align the text within the left section */
}
.active {
  background-color: #007bff;
  color: #fff;
}
.button-container button {
  margin-right: 10px; /* Adjust the value as per your preference */
  justify-content: center;
}
.btn-custom {
  background-color: #d41f1f; /* Replace with your desired color */
  color: #FFFFFF; /* Replace with your desired text color */
  font-size: 24px; /* Adjust the font size to make the button larger */
  padding: 16px 50px; /* Adjust the padding to increase the button size */
}


</style>
