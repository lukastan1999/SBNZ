<template>
  <div class="container">
    <!-- W E A T H E R  C O N D I T I O N  -->
    <h1>User Input Page</h1>
    <br/>

    <div class="button-container">
      <h2>Enter Weather Condition:</h2>
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
      <h2>Enter Depth of Field Condition:</h2>
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
      <h2>Enter Subject Movement Condition:</h2>
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
    <button type="button" class="btn btn-primary btn-lg btn-block" @click="handleSEND">Send</button>

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
    }
  },
  methods: {
    handleButtonClickWeather(button) {
      this.weatherCondition = button;
      console.log(this.weatherCondition);
    },
    handleButtonClickDepthoffield(button) {
      this.depthOfField = button;
      console.log(this.depthOfField);
    },
    handleButtonClickSubjectmovement(button) {
      this.subjectMovement = button;
      console.log(this.subjectMovement);
    },
    handleSEND() {
      let jsonData = {
        'weatherCondition': this.weatherCondition,
        'depthOfField': this.depthOfField,
        'subjectMovement': this.subjectMovement,
      };

      axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
      axios.defaults.headers.common['Content-Type'] = 'application/json';
      // axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.$store.getters.accessToken;
      axios.post('/photography/configure', jsonData)
        .then((response) => {
          // console.log("There has been success.");
          let data = response.data;

          console.log(data);

          // alert(response.data.message);
        }).catch((err) => {
          // alert("There has been a mistake.");
          alert(err.response.data.message);
          // console.log(err.response.data.message);

        });

    }
  },
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Adjust the value if needed */
}
.active {
  background-color: #007bff;
  color: #fff;
}
.button-container button {
  margin-right: 10px; /* Adjust the value as per your preference */
  justify-content: center;
}
</style>
